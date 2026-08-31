#include <bits/stdc++.h>
using namespace std;

int main() {
  int N, M, A, B = 1e9+7;
  cin >> N >> M;

  vector<int> vec(N + 1, -1);
  vec.at(0) = 1;
  vec.at(1) = 1;

  for (int i = 0; i < M; i++) {
    cin >> A;
    vec.at(A) = 0;
  }

  for (int i = 2; i < N + 1; i++) {
    if (vec.at(i) != 0) vec.at(i) = (vec.at(i - 2) + vec.at(i - 1)) % B;
  }

  cout << vec.at(N) << endl;
}