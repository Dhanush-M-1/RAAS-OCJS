#include <bits/stdc++.h>
using namespace std;
void p(vector<int> v) {
  for (int i = 0; i < v.size(); i++) {
    cout << v[i];
    if (i != v.size() - 1) {
      cout << endl;
    }
  }
}
int main() {
  int t;
  cin >> t;
  vector<int> ans;
  for (int i = 0; i < t; i++) {
    int sum = 0;
    int a;
    int b;
    int c;
    cin >> a;
    cin >> b;
    cin >> c;
    if (c <= 2 * b) {
      int temp = c / 2;
      sum += 3 * temp;
      b = b - c / 2;
      if (b <= 2 * a) {
        int x = b / 2;
        sum += 3 * x;
        ans.push_back(sum);
      } else {
        sum += 3 * a;
        ans.push_back(sum);
      }
    } else if (c > 2 * b) {
      int temp;
      sum += 3 * b;
      ans.push_back(sum);
    }
  }
  p(ans);
}
