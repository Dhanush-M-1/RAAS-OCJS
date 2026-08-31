#include <bits/stdc++.h>
#define ll long long
using namespace std;
ll a,b,c,d;
ll gcd(ll x,ll y){
    return y==0?x:gcd(y,x%y);
}
int main(){
    int t,flag; cin>>t;
    while(t--){
	flag=0;
	cin>>a>>b>>c>>d;
	if (d<b) flag=1;
	if (a<b) flag=1;
	a-=a/b*b;
	if (a>c) flag=1;
	d-=(d/b-1)*b;
	if (gcd(d,b)<b-c) flag=1;
	if (flag) puts("No");
	else puts("Yes");
    }
    return 0;
}
