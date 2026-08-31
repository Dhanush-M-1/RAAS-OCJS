#include <iostream>
#include <set>

using namespace std;
using ll = long long;
const ll MOD = 1000000007;

int main() {
  int N, M, a;
  cin >> N >> M;
  set<int> s;
  while(cin >> a) {
    s.insert(a);
  }

  ll dp[2] {1,0};
  for (int i = 1; i <= N; ++i) {
    dp[i%2] = s.count(i) ? 0 : (dp[0]+dp[1])%MOD;
  }
  cout << dp[N%2] << endl; 
}
