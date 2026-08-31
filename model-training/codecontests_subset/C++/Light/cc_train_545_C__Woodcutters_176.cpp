#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> x(n);
  vector<int> h(n);
  if (n == 1) {
    cout << 1 << endl;
  } else {
    cin >> x[0] >> h[0];
    int answer = 1;
    int at = 1;
    int left = x[0];
    cin >> x[1] >> h[1];
    for (int i = 1; i < n - 1; i++) {
      cin >> x[i + 1] >> h[i + 1];
      if (x[i] - h[i] > left) {
        left = x[i];
        answer++;
      } else if (x[i] + h[i] < x[i + 1]) {
        left = x[i] + h[i];
        answer++;
      } else {
        left = x[i];
      }
    }
    answer++;
    cout << answer << endl;
  }
}
