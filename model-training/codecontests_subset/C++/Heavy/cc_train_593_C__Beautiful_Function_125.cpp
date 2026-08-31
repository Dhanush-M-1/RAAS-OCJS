#include <bits/stdc++.h>
using namespace std;
void printfunc(vector<int> circs) {
  vector<string> ans;
  ans.push_back(to_string(circs[0]));
  int pos = circs[0];
  int slope = 0;
  for (int i = 1; i < circs.size(); i++) {
    int diff = (circs[i] - pos - slope) / 2;
    slope += diff * 2;
    pos += slope;
    string a = "(";
    if (diff < 0) {
      a += "(0" + to_string(diff) + ")";
    } else
      a += to_string(diff);
    a += "*(abs((t-" + to_string(i - 1) + "))+(t-" + to_string(i - 1) + ")))";
    ans.push_back(a);
  }
  for (int i = 0; i < ans.size() - 1; i++) {
    cout << "(";
  }
  cout << ans[0] << "+";
  for (int i = 1; i < ans.size() - 1; i++) {
    cout << ans[i] << ")+";
  }
  cout << ans.back() << ")";
  cout << endl;
}
int main() {
  int n;
  cin >> n;
  vector<int> x;
  vector<int> y;
  for (int i = 0; i < n; i++) {
    int a, b, r;
    cin >> a >> b >> r;
    x.push_back(a);
    y.push_back(b);
  }
  if (n == 1) {
    cout << x[0] << endl << y[0] << endl;
    return 0;
  }
  printfunc(x);
  printfunc(y);
}
