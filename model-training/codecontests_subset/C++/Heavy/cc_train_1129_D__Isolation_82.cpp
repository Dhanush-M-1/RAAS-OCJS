#include <bits/stdc++.h>
using namespace std;
using int64 = long long;
const int mod = 998244353;
int sqrtN = 128;
struct SqrtDecomposition {
  int N, K, tap, ans;
  vector<int> data;
  vector<int> bucketAdd;
  vector<int> uku;
  vector<unordered_map<int, int> > mp;
  SqrtDecomposition(int n, int tap) : N(n), tap(tap), ans(0) {
    K = (N + sqrtN - 1) / sqrtN;
    data.assign(n, 0);
    bucketAdd.assign(K, 0);
    uku.assign(n, 0);
    mp.resize(K);
  }
  void add(int s, int t) {
    for (int k = 0; k < K; ++k) {
      int l = k * sqrtN, r = min((k + 1) * sqrtN, (int)data.size());
      if (r <= s || t <= l) continue;
      if (s <= l && r <= t) {
        ++bucketAdd[k];
        if (mp[k].count(tap - bucketAdd[k])) {
          ans += mp[k][tap - bucketAdd[k]];
          if (ans >= mod) ans -= mod;
        }
      } else {
        for (int i = max(s, l); i < min(t, r); ++i) {
          mp[k][data[i]] += mod - uku[i];
          if (mp[k][data[i]] >= mod) mp[k][data[i]] -= mod;
          if (mp[k][data[i]] == 0) mp[k].erase(data[i]);
          ++data[i];
          mp[k][data[i]] += uku[i];
          if (mp[k][data[i]] >= mod) mp[k][data[i]] -= mod;
          if (data[i] + bucketAdd[k] == tap) {
            ans += uku[i];
            if (ans >= mod) ans -= mod;
          }
        }
      }
    }
  }
  void sub(int s, int t) {
    for (int k = 0; k < K; ++k) {
      int l = k * sqrtN, r = min((k + 1) * sqrtN, (int)data.size());
      if (r <= s || t <= l) continue;
      if (s <= l && r <= t) {
        if (mp[k].count(tap - bucketAdd[k])) {
          ans += mod - mp[k][tap - bucketAdd[k]];
          if (ans >= mod) ans -= mod;
        }
        --bucketAdd[k];
      } else {
        for (int i = max(s, l); i < min(t, r); ++i) {
          mp[k][data[i]] += mod - uku[i];
          if (mp[k][data[i]] >= mod) mp[k][data[i]] -= mod;
          if (mp[k][data[i]] == 0) mp[k].erase(data[i]);
          --data[i];
          mp[k][data[i]] += uku[i];
          if (mp[k][data[i]] >= mod) mp[k][data[i]] -= mod;
          if (data[i] + bucketAdd[k] == tap - 1) {
            ans += mod - uku[i];
            if (ans >= mod) ans -= mod;
          }
        }
      }
    }
  }
};
int main() {
  int K, N, A[100000];
  cin >> N >> K;
  ++K;
  vector<int> ap[100000];
  for (int i = 0; i < N; i++) {
    cin >> A[i];
    --A[i];
    ap[A[i]].emplace_back(i);
  }
  int last[100000];
  memset(last, -1, sizeof(last));
  for (int i = 0; i < N; i++) {
    for (int j = 1; j < ap[i].size(); j++) {
      last[ap[i][j]] = ap[i][j - 1];
    }
  }
  vector<int> dp(N + 1);
  dp[0] = 1;
  int appear[100000];
  int cor[100000];
  memset(appear, -1, sizeof(appear));
  memset(cor, -1, sizeof(cor));
  set<pair<pair<int, int>, int> > range;
  SqrtDecomposition seg(N + 1, K);
  int all = 1;
  seg.uku[0]++;
  seg.mp[0][0]++;
  for (int i = 1; i <= N; i++) {
    if (range.count(
            {make_pair(appear[A[i - 1]] + 1, cor[A[i - 1]] + 1), A[i - 1]})) {
      range.erase(
          {make_pair(appear[A[i - 1]] + 1, cor[A[i - 1]] + 1), A[i - 1]});
      seg.sub(appear[A[i - 1]] + 1, cor[A[i - 1]] + 1);
    }
    appear[A[i - 1]] = last[i - 1];
    cor[A[i - 1]] = i - 1;
    seg.add(appear[A[i - 1]] + 1, cor[A[i - 1]] + 1);
    range.emplace(make_pair(appear[A[i - 1]] + 1, cor[A[i - 1]] + 1), A[i - 1]);
    int add = (all + mod - seg.ans) % mod;
    (all += add) %= mod;
    (dp[i] += add) %= mod;
    (seg.uku[i] += add) %= mod;
    (seg.mp[i / sqrtN][seg.data[i]] += add) %= mod;
    if (seg.bucketAdd[i / sqrtN] + seg.data[i] >= K) {
      (seg.ans += add) %= mod;
    }
  }
  cout << dp[N] << endl;
}
