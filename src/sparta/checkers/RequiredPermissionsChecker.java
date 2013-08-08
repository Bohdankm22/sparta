package sparta.checkers;

import checkers.basetype.BaseTypeChecker;
import checkers.quals.StubFiles;
import checkers.quals.TypeQualifiers;
import checkers.quals.Unqualified;
import checkers.types.BasicAnnotatedTypeFactory;
import checkers.util.PurityChecker;

@TypeQualifiers(Unqualified.class)
@StubFiles("permission.astub")
public class RequiredPermissionsChecker extends BaseTypeChecker<BasicAnnotatedTypeFactory<RequiredPermissionsChecker>> {}