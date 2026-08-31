#include <bits/stdc++.h>
using namespace std;
double N;
int X;
int main() {
  cin >> N >> X;
  double K;
  cin >> K;
  int goal = ceil(N * K / 100.0);
  cout << max(goal - X, 0);
}
