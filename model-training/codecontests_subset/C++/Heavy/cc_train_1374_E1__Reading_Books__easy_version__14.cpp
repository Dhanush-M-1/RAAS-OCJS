#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
const long long maxn = 15e5 + 10;
const long long inf = 1e14;
long long n, m, k, t;
long long cur1, cur2;
long long C[maxn];
vector<long long> ANS;
vector<pair<long long, long long> > X[4];
void add(vector<long long> good) {
  long long mn = inf + 1, mni = 3;
  for (long long q = 0; q < 4; q++) {
    if (!good[q]) {
      continue;
    }
    if (X[q].back().first < mn) {
      mn = X[q].back().first;
      mni = q;
    }
  }
  ANS.push_back(X[mni].back().second);
  X[mni].pop_back();
  if (mni / 2 == 1) {
    cur2 = max(0LL, cur2 - 1);
  }
  if (mni % 2 == 1) {
    cur1 = max(0LL, cur1 - 1);
  }
}
void add1() { add({0, 1, 0, 1}); }
void add2() { add({0, 0, 1, 1}); }
void add0() { add({1, 1, 1, 1}); }
void add3() { add({0, 0, 0, 1}); }
void add_def() {
  long long q, w, e;
  vector<long long> mni = {0, 1};
  long long mn = inf;
  for (q = 0; q < 4; q++) {
    for (w = q + 1; w < 4; w++) {
      if ((q | w) != 3) {
        continue;
      }
      vector<long long> dmni = {q, w};
      long long dmn = X[q].back().first + X[w].back().first;
      if (dmn < mn) {
        mn = dmn;
        mni = dmni;
      }
    }
  }
  for (auto i : mni) {
    ANS.push_back(X[i].back().second);
    X[i].pop_back();
    if (i / 2 == 1) {
      cur2 = max(cur2 - 1, 0LL);
    }
    if (i % 2 == 1) {
      cur2 = max(cur2 - 1, 0LL);
    }
  }
}
bool used[maxn];
long long I[maxn];
int main() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long q, w, e, a, b, c;
  cin >> n >> m >> k;
  cur1 = cur2 = k;
  vector<pair<long long, long long> > ALL;
  for (q = 0; q < n; q++) {
    cin >> a >> b >> c;
    C[q] = a;
    long long i = b * 2 + c;
    X[i].push_back(make_pair(a, q));
    ALL.push_back(make_pair(a, q));
  }
  for (q = 0; q < n; q++) {
    for (w = 0; w < 4; w++) {
      X[w].push_back(make_pair(inf, n + q * 4 + w));
      ALL.push_back(make_pair(inf, n + q * 4 + w));
    }
  }
  long long alln = n + n * 4;
  sort(ALL.begin(), ALL.end());
  for (q = 0; q < 4; q++) {
    sort(X[q].begin(), X[q].end());
  }
  long long mn = 1e18, mni = 0;
  long long cur = 0;
  for (q = 0; q < k; q++) {
    cur += X[3][q].first;
    used[X[3][q].second] = 1;
  }
  for (q = 0; q < ALL.size(); q++) {
    I[ALL[q].second] = q;
  }
  long long cnt = 0;
  for (q = 0; cnt < m - k; q++) {
    if (used[ALL[q].second]) {
      continue;
    }
    cur += ALL[q].first;
    cnt++;
  }
  long long iall = q - 1;
  if (cur < mn) {
    mn = cur;
    mni = k;
  }
  for (q = k - 1; q >= 0; q--) {
    if (q + 2 * (k - q) > m) {
      break;
    }
    used[X[3][q].second] = 0;
    cur -= X[3][q].first;
    if (I[X[3][q].second] <= iall) {
      cur -= ALL[iall].first;
      cur += X[3][q].first;
      iall--;
      while (iall >= 0 && used[ALL[iall].second]) {
        iall--;
      }
    }
    long long i1 = k - q - 1;
    used[X[2][i1].second] = 1;
    cur += X[2][i1].first;
    if (I[X[2][i1].second] <= iall) {
      cur -= X[2][i1].first;
      iall++;
      while (used[ALL[iall].second]) {
        iall++;
      }
      cur += ALL[iall].first;
    }
    used[X[1][i1].second] = 1;
    cur += X[1][i1].first;
    if (I[X[1][i1].second] <= iall) {
      cur -= X[1][i1].first;
      iall++;
      while (used[ALL[iall].second]) {
        iall++;
      }
      cur += ALL[iall].first;
    }
    cur -= ALL[iall].first;
    iall--;
    while (iall >= 0 && used[ALL[iall].second]) {
      iall--;
    }
    if (cur < mn) {
      mn = cur;
      mni = q;
    }
  }
  for (q = 0; q < alln; q++) {
    used[q] = 0;
  }
  for (q = 0; q < mni; q++) {
    ANS.push_back(X[3][q].second);
    used[X[3][q].second] = 1;
  }
  for (q = 0; q < k - mni; q++) {
    ANS.push_back(X[1][q].second);
    used[X[1][q].second] = 1;
    ANS.push_back(X[2][q].second);
    used[X[2][q].second] = 1;
  }
  cnt = 0;
  for (q = 0; cnt < m - mni - 2 * (k - mni); q++) {
    if (!used[ALL[q].second]) {
      ANS.push_back(ALL[q].second);
      cnt++;
    }
  }
  for (auto i : ANS) {
    if (i >= n) {
      cout << -1;
      return 0;
    }
  }
  cout << mn << endl;
  for (q = 0; q < ANS.size(); q++) {
    cout << ANS[q] + 1 << " ";
  }
  return 0;
}
