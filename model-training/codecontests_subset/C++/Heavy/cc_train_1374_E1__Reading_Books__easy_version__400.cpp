#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 100;
const int inf = 1e9 + 7;
const long long mod = 1e9 + 7;
int a[maxn];
int b[maxn];
int t[maxn];
vector<int> both;
vector<int> alice;
vector<int> bob;
int psum_alice[maxn];
int psum_bob[maxn];
int psum_both[maxn];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> t[i] >> a[i] >> b[i];
    if (a[i] == 1 && b[i] == 1) {
      both.push_back(t[i]);
    } else if (a[i] == 1) {
      alice.push_back(t[i]);
    } else if (b[i] == 1) {
      bob.push_back(t[i]);
    }
  }
  sort(both.begin(), both.end());
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  for (int i = 0; i < both.size(); i++) {
    psum_both[i + 1] = psum_both[i] + both[i];
  }
  for (int i = 0; i < alice.size(); i++) {
    psum_alice[i + 1] = psum_alice[i] + alice[i];
  }
  for (int i = 0; i < bob.size(); i++) {
    psum_bob[i + 1] = psum_bob[i] + bob[i];
  }
  long long ans = -1;
  for (int i = 0; i <= k; i++) {
    if (i > both.size() || k - i > alice.size() || k - i > bob.size()) {
      continue;
    }
    long long subans = psum_both[i] + psum_alice[k - i] + psum_bob[k - i];
    if (ans == -1 || subans < ans) {
      ans = subans;
    }
  }
  cout << ans << endl;
}
