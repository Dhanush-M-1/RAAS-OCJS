#include <bits/stdc++.h>
using namespace std;
long long n, m, k, t[200005], a[200005], b[200005];
vector<pair<long long, long long> > ta, tb, tboth, tnone;
multiset<long long> second;
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m >> k;
  for (long long i = 1; i <= n; ++i) cin >> t[i] >> a[i] >> b[i];
  long long cnta = 0, cntb = 0, cntboth = 0, cntnone = 0;
  for (long long i = 1; i <= n; ++i) {
    if (a[i] == 1 && b[i] == 1) {
      tboth.push_back(make_pair(t[i], i));
      cntboth++;
    } else if (a[i] == 1) {
      ta.push_back(make_pair(t[i], i));
      cnta++;
    } else if (b[i] == 1) {
      tb.push_back(make_pair(t[i], i));
      cntb++;
    } else {
      tnone.push_back(make_pair(t[i], i));
      cntnone++;
    }
  }
  sort(tboth.begin(), tboth.end());
  sort(ta.begin(), ta.end());
  sort(tb.begin(), tb.end());
  sort(tnone.begin(), tnone.end());
  long long ans = 1000000007LL * 10000;
  long long cboth = 0, cnone = 0, ca = 0, cb = 0, tot = 0;
  long long iboth = min(m, cntboth) - 1, ia = -1, ib = -1, inone = -1;
  long long besta, bestb, bestboth, bestnone;
  for (long long i = 0; i <= iboth; ++i) cboth += tboth[i].first;
  tot = iboth + 1;
  for (long long i = iboth; i >= -1; --i) {
    long long sep = (k - (i + 1));
    if (sep > cntb || sep > cnta) continue;
    if (2 * sep + iboth + 1 > m) continue;
    while (ia < sep - 1) {
      ia++;
      ca += ta[ia].first;
      tot++;
      if (tot > m) {
        if (ib == -1) {
          cnone -= tnone[inone].first;
          inone--;
          tot--;
        } else if (inone == -1) {
          cb -= tb[ib].first;
          ib--;
          tot--;
        } else if (ib < sep || tnone[inone].first >= tb[ib].first) {
          cnone -= tnone[inone].first;
          inone--;
          tot--;
        } else {
          cb -= tb[ib].first;
          ib--;
          tot--;
        }
      }
    }
    while (ib < sep - 1) {
      ib++;
      cb += tb[ib].first;
      tot++;
      if (tot > m) {
        if (ia == -1) {
          cnone -= tnone[inone].first;
          inone--;
          tot--;
        } else if (inone == -1) {
          ca -= ta[ia].first;
          ia--;
          tot--;
        } else if (ia < sep || tnone[inone].first >= ta[ia].first) {
          cnone -= tnone[inone].first;
          inone--;
          tot--;
        } else {
          ca -= ta[ia].first;
          ia--;
          tot--;
        }
      }
    }
    while (tot < m) {
      long long mn = 1000000007LL, val = -1;
      if (ia + 1 < cnta && (val == -1 || mn >= ta[ia + 1].first)) {
        mn = ta[ia + 1].first;
        val = 1;
      }
      if (ib + 1 < cntb && (val == -1 || mn >= tb[ib + 1].first)) {
        mn = tb[ib + 1].first;
        val = 2;
      }
      if (inone + 1 < cntnone && (val == -1 || mn >= tnone[inone + 1].first)) {
        mn = tnone[inone + 1].first;
        val = 3;
      }
      if (val == 1) {
        ia++;
        ca += ta[ia].first;
        tot++;
      } else if (val == 2) {
        ib++;
        cb += tb[ib].first;
        tot++;
      } else if (val == 3) {
        inone++;
        cnone += tnone[inone].first;
        tot++;
      } else
        break;
    }
    if (tot == m && ans > cboth + ca + cb + cnone) {
      ans = cboth + ca + cb + cnone;
      bestboth = iboth;
      besta = ia;
      bestb = ib;
      bestnone = inone;
    }
    if (i >= 0) {
      cboth -= tboth[i].first;
      tot--;
      iboth--;
    }
  }
  if (ans == 1000000007LL * 10000) {
    cout << -1 << endl;
    return 0;
  } else {
    cout << ans << "\n";
    if (cntboth > 0)
      for (long long i = 0; i <= bestboth; ++i) cout << tboth[i].second << " ";
    if (cnta > 0)
      for (long long i = 0; i <= besta; ++i) cout << ta[i].second << " ";
    if (cntb > 0)
      for (long long i = 0; i <= bestb; ++i) cout << tb[i].second << " ";
    if (cntnone > 0)
      for (long long i = 0; i <= bestnone; ++i) cout << tnone[i].second << " ";
    cout << endl;
  }
}
