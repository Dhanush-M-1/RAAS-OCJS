#include <cstdio>
typedef long long lint;

lint gcd(lint x,lint y){
    return y==0?x:gcd(y,x%y);
}

int main(){
    int T;
    scanf("%d",&T);
    lint A,B,C,D;
    while(T--){
        scanf("%lld%lld%lld%lld",&A,&B,&C,&D);
        lint g = gcd(B,D);
        if(A>=B && A%B<=C && D>=B && B-g<=C){
            puts("Yes");
        }else{
            puts("No");
        }
    }
    return 0;
}
