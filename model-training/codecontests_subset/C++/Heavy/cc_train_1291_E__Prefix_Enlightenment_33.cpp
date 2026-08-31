#include <bits/stdc++.h>
using namespace std;
struct perem {
  int t = 0, l = 1, p = -1, q = 0;
};
ifstream fin("AAtest.in.txt");
int n, k, m, c, vas, cc = 1000000, kl;
vector<int> vv;
string s;
vector<vector<int>> la;
vector<perem> pr;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cerr.tie(0);
  cin >> n >> k >> s;
  la.resize(n, vector<int>(0));
  pr.resize(k);
  for (int(i) = (0); ((i)) < ((k)); ((i))++) {
    cin >> m;
    for (int(j) = (0); ((j)) < ((m)); ((j))++) {
      cin >> c;
      la[c - 1].emplace_back(i);
    }
  }
  for (int(i) = (0); ((i)) < ((n)); ((i))++) {
    vas = 0;
    if (la[i].size() > 0) {
      int a = la[i][0];
      bool d = s[i] == '1' ? 1 : 0;
      for (;; a = pr[a].p) {
        d ^= pr[a].q;
        if (pr[a].p == -1) break;
      }
      if (la[i].size() == 1) {
        if (!d) {
          vas += pr[a].l;
          pr[a].q ^= 1;
        }
        pr[a].l = cc;
      } else {
        int b = la[i][1];
        for (;; b = pr[b].p) {
          d ^= pr[b].q;
          if (pr[b].p == -1) break;
        }
        if (a != b) {
          if (!d) {
            if (pr[a].l > pr[b].l) swap(a, b);
            vas += pr[a].l;
            pr[a].q ^= 1;
            kl = abs(pr[a].l - pr[b].l);
          } else
            kl = min(pr[a].l + pr[b].l, cc);
          if (pr[a].t < pr[b].t) swap(a, b);
          if (pr[a].q) pr[b].q ^= 1;
          if (pr[a].t == pr[b].t) pr[a].t++;
          pr[a].l = kl;
          pr[b].p = a;
        }
      }
    }
    if (i)
      vv.emplace_back(vv.back() + vas);
    else
      vv.emplace_back(vas);
  }
  for (int i : vv) cout << i << endl;
}
