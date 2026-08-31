#include<cstdio>
#include<cstring>
#include<algorithm>
#include<cmath>
using namespace std;

typedef long long ll;

ll a,b,c,d;

ll gcd(ll x,ll y){
    if(!y) return x;
    return gcd(y,x%y);
}

int main(){
    int T;
    scanf("%d",&T);
    while(T--){
        scanf("%lld%lld%lld%lld",&a,&b,&c,&d);
        if(a<b||d<b){printf("No\n"); continue;}
        if(c>=b){printf("Yes\n"); continue;}
        ll l=a-b,r=a-c-1;
        ll x=gcd(b,d);
        if(r/x-l/x>0) printf("No\n");
        else printf("Yes\n");
    }
}

