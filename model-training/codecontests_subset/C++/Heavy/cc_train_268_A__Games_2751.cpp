#include <bits/stdc++.h>
using namespace std;
const long long mod7 = 1000000007;
long long GCD(long long a, long long b) { return b == 0 ? a : GCD(b, a % b); }
long long A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W,
    X, Y, Z;
long long temp;
char tempChar;
string tempString;
vector<int> homeColors;
vector<int> guestColors;
int main() {
  cin >> N;
  for (long long j = 0; j < N; j++) {
    cin >> A >> B;
    homeColors.push_back(A);
    guestColors.push_back(B);
  }
  for (long long i = 0; i < N; i++) {
    for (long long j = 0; j < N; j++) {
      if (homeColors[i] == guestColors[j] && i != j) S++;
    }
  }
  cout << S << endl;
}
