#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int t;
ll a,b,c,d;
ll gcd(ll x,ll y){return y?gcd(y,x%y):x;}
int main(){
    cin>>t;
    while(t--){
        cin>>a>>b>>c>>d;
        if(a<b){
            printf("No\n");continue;
        }
        if(b>d){
            printf("No\n");continue;
        }
        if(c>=(b-1)){
            printf("Yes\n");continue;
        }
        if(((a%b+((b-1-a%b)/gcd(b,d))*gcd(b,d))>c)) printf("No\n");
        else printf("Yes\n");

    }
    return 0;
}
