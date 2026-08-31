#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
typedef vector<vector<ll>> matrix;

ll l[200005];
ll dpR[200005];
ll dpL[200005];

void solve() {
  int n;
  cin >> n;
  ll d;
  cin >> d;
  ll ret = 0;
  for(int i = 0; i < n; i++) {
    cin >> l[i];
    ret += l[i];
  }
  ret += (n-1)*d;
  dpR[0] = l[0];
  for(int i = 1; i < n; i++) {
    dpR[i] = min(l[i], dpR[i-1] + d);
  }
  dpL[n-1] = l[n-1];
  for(int i = n-2; i >= 0; i--) {
    dpL[i] = min(l[i], dpL[i+1] + d);
  }
  for(int i = 1; i < n-1; i++) {
    ret += min(dpL[i], dpR[i]);
  }
  cout << ret << endl;
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
  solve();
}
