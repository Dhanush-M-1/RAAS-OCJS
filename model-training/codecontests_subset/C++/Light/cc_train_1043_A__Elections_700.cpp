#include <bits/stdc++.h>
using namespace std;
static const string YES = "YES", NO = "NO";
int main() {
  int n;
  cin >> n;
  int sum = 0;
  int MAX = -1;
  int x;
  for (int i = (0); i < (n); ++i) {
    cin >> x;
    sum += x;
    MAX = max(x, MAX);
  }
  double avg = 1.0 * sum / n;
  int result = max(MAX, 2 * sum / n + 1);
  cout << result;
}
