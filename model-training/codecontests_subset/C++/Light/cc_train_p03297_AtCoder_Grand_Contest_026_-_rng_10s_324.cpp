#include <iostream>
using namespace std;

typedef long long ll;

ll gcd(ll n,ll m){
  if(m==0) return n;
  else return gcd(m,n%m);
}

int main(){
  ll n,a,b,c,d,ok;
  cin >> n;
  for(ll i=0;i<n;i++){
    cin >> a >> b >> c >> d;
    ll x=gcd(b,d);
    ll ok=b-x+a%x;
    if(a<b||d<b) cout << "No" << endl;
    else if(c>=b) cout << "Yes" << endl;
    else if(c>=ok) cout << "Yes" << endl;
    else cout << "No" << endl;
  }
}
