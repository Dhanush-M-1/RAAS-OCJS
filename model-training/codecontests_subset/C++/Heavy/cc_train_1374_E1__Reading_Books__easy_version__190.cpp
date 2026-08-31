#include <bits/stdc++.h>
using namespace std;
void solution() {
  int n, k;
  cin >> n >> k;
  vector<int> zero, one, two;
  for (int i = 0; i < n; i++) {
    int t1, t2, t3;
    cin >> t1 >> t2 >> t3;
    if (t2 == 0 && t3 == 1) {
      one.push_back(t1);
    } else if (t2 == 1 && t3 == 0) {
      zero.push_back(t1);
    } else if (t2 == 1 && t3 == 1) {
      two.push_back(t1);
    }
  }
  sort(zero.begin(), zero.end());
  sort(one.begin(), one.end());
  sort(two.begin(), two.end());
  int last = 0;
  int output = -1;
  for (int i = 1; i < min(one.size(), zero.size()); i++) {
    one[i] += one[i - 1];
    zero[i] += zero[i - 1];
  }
  for (int i = 0; i <= min(k, (int)two.size()); i++) {
    last += (i > 0 ? two[i - 1] : 0);
    if (k - i > min(zero.size(), one.size())) {
      continue;
    }
    int t_output = last + (k - i > 0 ? one[k - i - 1] + zero[k - i - 1] : 0);
    if (t_output < output || output == -1) {
      output = t_output;
    }
  }
  cout << output << endl;
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int count, counter = 0;
  count = 1;
  while (counter++ < count) {
    solution();
  }
  return 0;
}
