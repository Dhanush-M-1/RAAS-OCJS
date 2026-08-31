#include <bits/stdc++.h>
using namespace std;
int n, a, answer;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    answer = max(answer, min(a - 1, 1000000 - a));
  }
  cout << answer;
}
