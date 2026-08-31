#include <iostream>
#include <cmath>
using namespace std;

int main(){
  long long int n, m, a, b, p, q, ans;
  cin >> n >> m >> a >> b >> p >> q;
  if(a < b){
    swap(a, b);
    swap(p, q);
  }
  if(a == 1LL){
    if(m/(p + q) >= n) cout << m - n*(p + q) << endl;
    else{
      long long int t = m - m/(p + q)*(p + q);
      cout << min(t, p + q - t) << endl;
    }
    return 0;
  }
  ans = m;
  long long int x = 1LL, y = 1LL;
  for(int i = 1; i < n; ++i){
    if(m <= p*x + q*y) break;
    if(x > (1LL<<40)/a || y > (1LL<<40)/b) break;
    x *= a;
    y *= b;
  }

  while(x > 0){
    ans = min(ans, abs(m - (p*x + q*y)));
    if(m >= p*x + q*y) m -= p*x + q*y;
    x /= a;
    y /= b;
  }
  cout << ans << endl;
  return 0;
}

