#include <bits/stdc++.h>
using namespace std;

bool acceptable(const vector<int> w, int i) {
  const vector<int> tanku = {5, 7, 5, 7, 7};
  for (int ku : tanku) {
    int sum = 0;
    while (sum < ku) {
      sum += w[i++];
    }
    if (sum != ku) {
      return false;
    }
  }
  return true;
}

int main() {
  int N;
  while (cin >> N && N) {
    vector<int> W(N);
    for (int i = 0; i < N; ++i) {
      string str;
      cin >> str;
      W[i] = str.length();
    }
    for (int i = 1; i <= N; ++i) {
      if (acceptable(W, i - 1)) {
        cout << i << endl;
        break;
      }
    }
  }
}