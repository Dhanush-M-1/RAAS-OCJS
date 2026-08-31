#include <cstdio>
#include <iostream>
#define ll long long
int t;
ll a,b,c,d;
ll gcd(ll x,ll y) {return y == 0 ? x : gcd(y, x%y);
}
int main() {
    std :: cin >> t;
    while(std :: cin >> a >> b >> c >> d){
        ll g=gcd(b,d);
        if(a<b || b>d || ((a-c-1ll)/g-(a-b)/g>0)) puts("No");
        else puts("Yes");
    }
} 