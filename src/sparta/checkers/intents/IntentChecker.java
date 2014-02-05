package sparta.checkers.intents;

import checkers.basetype.BaseTypeVisitor;
import checkers.quals.PolyAll;
import checkers.quals.StubFiles;
import checkers.quals.TypeQualifiers;
import checkers.source.SupportedLintOptions;

import javax.annotation.processing.SupportedOptions;

import sparta.checkers.FlowChecker;
import sparta.checkers.FlowPolicy;
import sparta.checkers.quals.IExtra;
import sparta.checkers.quals.IntentExtras;
import sparta.checkers.quals.PolySink;
import sparta.checkers.quals.PolySource;
import sparta.checkers.quals.Sink;
import sparta.checkers.quals.Source;

@TypeQualifiers({ Source.class, Sink.class, PolySource.class, PolySink.class, PolyAll.class,
        IntentExtras.class, IExtra.class })
@StubFiles("information_flow.astub")
@SupportedOptions({ FlowPolicy.POLICY_FILE_OPTION, ComponentMap.COMPONENT_MAP_FILE_OPTION,
        FlowChecker.MSG_FILTER_OPTION, FlowChecker.IGNORE_NOT_REVIEWED })
@SupportedLintOptions({ FlowPolicy.STRICT_CONDITIONALS_OPTION })
public class IntentChecker extends FlowChecker {

    // Uncomment below to only report intent type checks.
    // @Override
    // public void report(Result r, Object src) {
    // List<String> messageKeys = r.getMessageKeys();
    // if (messageKeys.contains("intent.key.notfound")
    // || messageKeys.contains("intent.type.incompatible")
    // || messageKeys.contains("send.intent")
    // || messageKeys.contains("getintent.not.found")) {
    // super.report(r, src);
    // }
    // }
    
 
    @Override
    protected BaseTypeVisitor<?> createSourceVisitor() {
        try {
            return new IntentVisitor(this);
        } catch (Exception e) {
            //The SourceVisitor cuts off the stack trace, 
            //so print it here and the throw again.
            e.printStackTrace();
            throw e;
        }
    }

}