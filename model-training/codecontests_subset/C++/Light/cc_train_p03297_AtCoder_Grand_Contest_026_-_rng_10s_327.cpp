#include<bits/stdc++.h>
using namespace std;
long g(long m,long n){
  return (n==0?m:g(n,m%n));
}
int main(){
  long n, a, b, c, d;
  cin >> n;
  for(int i=0;i<n;i++){
    cin >> a >> b >> c >> d;
    cout << ((c>=b-g(b,d)+a%g(b,d)||c>=b)&&!(b>a||b>d)?"Yes":"No") << endl;
  }
  return 0;
}