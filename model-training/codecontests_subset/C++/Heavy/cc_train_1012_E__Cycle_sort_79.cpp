#include <bits/stdc++.h>
using namespace std;
const long long big = 1000000007;
const long long mod = 998244353;
long long n, m, k, T, q;
vector<long long> A, A2;
map<long long, long long> M;
long long d = 0;
long long pek[200001] = {0};
long long deg[200001] = {0};
long long par(long long i) {
  long long i2 = i;
  while (i2 != pek[i2]) {
    i2 = pek[i2];
  }
  return i2;
}
void merg(long long i, long long j) {
  long long i2 = par(i);
  long long j2 = par(j);
  if (i2 != j2) {
    if (deg[i2] < deg[j2]) swap(i2, j2);
    deg[i2] += deg[j2];
    pek[j2] = i2;
  }
}
vector<long long> extramove;
vector<long long> thing;
vector<set<long long> > C(400001, set<long long>());
long long indeg[400001] = {0};
long long outdeg[400001] = {0};
vector<vector<long long> > anses;
vector<long long> eulertour(int i) {
  vector<long long> ANS;
  vector<long long> vts;
  long long j = i;
  while (outdeg[j] > 0) {
    vts.push_back(j);
    long long j2 = j;
    j = *(C[j].begin());
    C[j2].erase(j);
    outdeg[j2]--;
    indeg[j]--;
  }
  ANS.push_back(i);
  for (int c1 = 1; c1 < (int)(vts).size(); c1++) {
    vector<long long> nt = eulertour(vts[c1]);
    for (int c2 = 0; c2 < (int)(nt).size(); c2++) {
      ANS.push_back(nt[c2]);
    }
    if ((int)(nt).size() > 1) {
      ANS.push_back(vts[c1]);
    }
  }
  return ANS;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long a, b, c;
  cin >> n >> m;
  for (int c1 = 0; c1 < n; c1++) {
    cin >> a;
    A.push_back(a);
    A2.push_back(a);
  }
  sort(A2.begin(), A2.end());
  for (int c1 = 0; c1 < n; c1++) {
    if (M.find(A2[c1]) == M.end()) {
      M[A2[c1]] = d;
      d++;
    }
  }
  for (int c1 = 0; c1 < n; c1++) {
    A[c1] = M[A[c1]];
    A2[c1] = M[A2[c1]];
  }
  long long nonfix = 0;
  for (int c1 = 0; c1 < n; c1++) {
    if (A[c1] != A2[c1]) nonfix++;
  }
  if (m < nonfix) {
    cout << "-1\n";
    return 0;
  }
  vector<long long> B;
  vector<long long> B2;
  for (int c1 = 0; c1 < n; c1++) {
    if (A[c1] != A2[c1]) {
      B.push_back(A[c1]);
      B2.push_back(A2[c1]);
      thing.push_back(c1 + 1);
    }
  }
  A.clear();
  A2.clear();
  n = (int)(B).size();
  if (n == 0) {
    cout << "0\n";
    return 0;
  }
  for (int c1 = 0; c1 < n; c1++) {
    A.push_back(B[c1]);
    A2.push_back(B2[c1]);
  }
  d = 0;
  M.clear();
  for (int c1 = 0; c1 < n; c1++) {
    if (M.find(A2[c1]) == M.end()) {
      M[A2[c1]] = d;
      d++;
    }
  }
  for (int c1 = 0; c1 < n; c1++) {
    A[c1] = M[A[c1]];
    A2[c1] = M[A2[c1]];
  }
  for (int c1 = 0; c1 < d; c1++) {
    deg[c1] = 1;
    pek[c1] = c1;
  }
  long long comps = d;
  for (int c1 = 0; c1 < n; c1++) {
    if (par(A[c1]) != par(A2[c1])) {
      merg(A[c1], A2[c1]);
      comps--;
    }
  }
  long long leftovers = m - n;
  long long ans = 0;
  if (leftovers >= 3 && comps > 2) {
    extramove.push_back(0);
    leftovers--;
    for (int c1 = 0; c1 < n; c1++) {
      if (leftovers == 0) break;
      if (par(A[0]) != par(A[c1])) {
        leftovers--;
        merg(A[0], A[c1]);
        extramove.push_back(c1);
      }
    }
    long long old = A[extramove[(int)(extramove).size() - 1]];
    for (int c1 = (int)(extramove).size() - 1; c1 >= 1; c1--) {
      A[extramove[c1]] = A[extramove[c1 - 1]];
    }
    A[0] = old;
    ans++;
  }
  for (int c1 = 0; c1 < n; c1++) {
    if (A[c1] != A2[c1]) {
      C[A2[c1] + n].insert(c1);
      C[c1].insert(A[c1] + n);
      indeg[c1]++;
      outdeg[c1]++;
      indeg[A[c1] + n]++;
      outdeg[A2[c1] + n]++;
    }
  }
  for (int c1 = 0; c1 < n; c1++) {
    if (indeg[c1] > 0) {
      vector<long long> AA = eulertour(c1);
      vector<long long> BB;
      for (int c2 = 0; c2 < (int)(AA).size(); c2 += 2) {
        BB.push_back(AA[c2]);
      }
      anses.push_back(BB);
    }
  }
  cout << ans + (int)(anses).size() << "\n";
  if ((int)(extramove).size() > 0) {
    cout << (int)(extramove).size() << "\n";
    for (int c1 = 0; c1 < (int)(extramove).size(); c1++) {
      cout << thing[extramove[c1]] << " ";
    }
    cout << "\n";
  }
  for (int c2 = 0; c2 < (int)(anses).size(); c2++) {
    cout << (int)(anses[c2]).size() << "\n";
    for (int c1 = 0; c1 < (int)(anses[c2]).size(); c1++) {
      cout << thing[anses[c2][c1]] << " ";
    }
    cout << "\n";
  }
  return 0;
}
