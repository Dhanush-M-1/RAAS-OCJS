#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return a % b == 0 ? b : gcd(b, a % b); }
vector<long long> G;
int main() {
  long long N;
  while (cin >> N) {
    G.clear();
    for (long long i = 2; i * i <= N; i++)
      while (N % i == 0) {
        G.push_back(i);
        N /= i;
      }
    if (N > 1) G.push_back(N);
    if (G.size() < 2)
      cout << 1 << endl << 0 << endl;
    else if (G.size() == 2)
      cout << 2 << endl;
    else
      cout << 1 << endl << G[0] * G[1] << endl;
  }
  return 0;
}
