#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  for (int i = 0; i < T; i++) {
    int N;
    cin >> N;
    vector<int> vec(N);
    for (int j = 0; j < N; j++) {
      cin >> vec.at(j);
    }
    if (vec.at(0) + vec.at(1) <= vec.at(N - 1)) {
      cout << 1 << " " << 2 << " " << N << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
