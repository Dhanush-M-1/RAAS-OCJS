#include <bits/stdc++.h>
using namespace std;
struct l6 {
  l6(long long a, long long b, long long c, long long d, long long e,
     long long first, int p = 0) {
    vals[0] = a;
    vals[1] = b;
    vals[2] = c;
    vals[3] = d;
    vals[4] = e;
    vals[5] = first;
    pow10_val = p;
  }
  l6 cop() {
    return l6(vals[0], vals[1], vals[2], vals[3], vals[4], vals[5],
              pow10_val + 1);
  }
  long long vals[6];
  int pow10_val;
};
vector<int> XtoA[10];
vector<int> XtoB[10];
int main() {
  std::ios_base::sync_with_stdio(false);
  for (int X = 0; X < 10; X++) {
    XtoA[X] = vector<int>();
    XtoB[X] = vector<int>();
    for (int A = 0; A <= 6; A++) {
      for (int B = 0; B + A <= 6; B++) {
        if ((7 * A + 4 * B) % 10 == X) {
          XtoA[X].push_back(A);
          XtoB[X].push_back(B);
        }
      }
    }
  }
  int T;
  cin >> T;
  long long N;
  long long nums[6];
  bool w;
  long long X, A, B, C, R;
  while (T--) {
    cin >> N;
    w = false;
    long long pow10 = 1;
    int prev10 = 0;
    for (int i = 0; i < 6; i++) {
      nums[i] = 0;
    }
    queue<l6> Q;
    set<long long> seenNums = {N};
    Q.push(l6(0, 0, 0, 0, 0, 0));
    while (Q.size()) {
      l6 a = Q.front();
      Q.pop();
      if (a.pow10_val != prev10) {
        prev10 = a.pow10_val;
        pow10 *= 10;
      }
      long long sub = 0;
      for (int i = 0; i < 6; i++) {
        sub += a.vals[i];
      }
      R = N - sub;
      if (R == 0) {
        w = true;
        for (long long i : a.vals) cout << i << " ";
        cout << "\n";
        break;
      }
      R /= pow10;
      X = R % 10;
      if (R < 4) continue;
      for (int i = 0; i < XtoA[X].size(); i++) {
        A = XtoA[X][i];
        B = XtoB[X][i];
        C = 6 - A - B;
        if (A * 7 + 4 * B > R) continue;
        l6 b = a.cop();
        long long added = 0;
        for (int ii = 0; ii < 6; ii++) {
          if (ii < A) {
            b.vals[ii] += 7 * pow10;
            added += 7 * pow10;
          } else if (ii < A + B) {
            b.vals[ii] += 4 * pow10;
            added += 4 * pow10;
          }
        }
        if (C == 6 || seenNums.find(N - sub - added) == seenNums.end()) {
          seenNums.insert(N - sub - added);
          Q.push(b);
        }
      }
    }
    if (!w) cout << "-1\n";
  }
}
