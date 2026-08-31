#include <bits/stdc++.h>
#pragma GCC optimize(3)
#pragma GCC optimize("Ofast")
#pragma GCC optimize("inline")
#pragma GCC optimize("-fgcse")
#pragma GCC optimize("-fgcse-lm")
#pragma GCC optimize("-fipa-sra")
#pragma GCC optimize("-ftree-pre")
#pragma GCC optimize("-ftree-vrp")
#pragma GCC optimize("-fpeephole2")
#pragma GCC optimize("-ffast-math")
#pragma GCC optimize("-fsched-spec")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-falign-jumps")
#pragma GCC optimize("-falign-loops")
#pragma GCC optimize("-falign-labels")
#pragma GCC optimize("-fdevirtualize")
#pragma GCC optimize("-fcaller-saves")
#pragma GCC optimize("-fcrossjumping")
#pragma GCC optimize("-fthread-jumps")
#pragma GCC optimize("-funroll-loops")
#pragma GCC optimize("-fwhole-program")
#pragma GCC optimize("-freorder-blocks")
#pragma GCC optimize("-fschedule-insns")
#pragma GCC optimize("inline-functions")
#pragma GCC optimize("-ftree-tail-merge")
#pragma GCC optimize("-fschedule-insns2")
#pragma GCC optimize("-fstrict-aliasing")
#pragma GCC optimize("-fstrict-overflow")
#pragma GCC optimize("-falign-functions")
#pragma GCC optimize("-fcse-skip-blocks")
#pragma GCC optimize("-fcse-follow-jumps")
#pragma GCC optimize("-fsched-interblock")
#pragma GCC optimize("-fpartial-inlining")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("-freorder-functions")
#pragma GCC optimize("-findirect-inlining")
#pragma GCC optimize("-fhoist-adjacent-loads")
#pragma GCC optimize("-frerun-cse-after-loop")
#pragma GCC optimize("inline-small-functions")
#pragma GCC optimize("-finline-small-functions")
#pragma GCC optimize("-ftree-switch-conversion")
#pragma GCC optimize("-foptimize-sibling-calls")
#pragma GCC optimize("-fexpensive-optimizations")
#pragma GCC optimize("-funsafe-loop-optimizations")
#pragma GCC optimize("inline-functions-called-once")
#pragma GCC optimize("-fdelete-null-pointer-checks")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,popcnt,abm,mmx,tune=native")
#pragma GCC optimize("fast-math")
#pragma warning(disable : 4996)
using namespace std;
mt19937 rnd(time(nullptr));
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long n, m;
  cin >> n >> m;
  vector<long long> p(n);
  map<long long, long long> smth;
  for (long long i = 0; i < n; i++) {
    cin >> p[i];
    p[i]--;
    smth[p[i]] = i;
  }
  vector<vector<long long> > graph(n);
  for (long long i = 0; i < m; i++) {
    long long a, b;
    cin >> a >> b;
    a--;
    b--;
    graph[b].push_back(a);
  }
  vector<pair<long long, long long> > all;
  vector<long long> need = graph[p.back()];
  for (long long i = 0; i < need.size(); i++) {
    all.push_back({smth[need[i]], need[i]});
  }
  sort(all.begin(), all.end());
  reverse(all.begin(), all.end());
  long long last = n - 1;
  long long bad = 0;
  vector<long long> used(n + 7);
  long long ans = 0;
  for (long long i = 0; i < all.size(); i++) {
    for (long long j = last - 1; j > all[i].first; j--) {
      for (auto to : graph[p[j]]) {
        used[to]++;
      }
    }
    long long now = all[i].first;
    long long el = all[i].second;
    if (used[el] == (n - 1) - now - i - 1 + bad)
      ans++;
    else {
      for (auto to : graph[el]) {
        used[to]++;
      }
      bad++;
    }
    last = all[i].first;
  }
  cout << ans << "\n";
  return 0;
}
