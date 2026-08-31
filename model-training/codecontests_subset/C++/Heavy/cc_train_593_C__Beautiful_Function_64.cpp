#include <bits/stdc++.h>
#pragma comment(linker, "/stack:20000000")
using namespace std;
vector<pair<int, int> > items;
void createFunc(int *values, int n, int t, int coef, int c) {
  if (n <= 0) return;
  int val = (t + 1) * coef + c;
  int target = (values[0] - val) / 2;
  if (target != 0) items.push_back(make_pair(target, t));
  createFunc(values + 1, n - 1, t + 1, coef + target * 2, c - (t)*2 * target);
}
void printNum(int n) {
  if (n >= 0)
    cout << n;
  else
    cout << "(0-" << (-n) << ")";
}
void printFunc(int c, int i) {
  if (i != items.size() - 1) cout << "(";
  cout << "((abs((t-" << items[i].second << "))+(t-" << items[i].second
       << "))*";
  printNum(items[i].first);
  cout << ")";
  if (i != items.size() - 1) {
    cout << "+";
    printFunc(c, i + 1);
    cout << ")";
  }
}
void printFunc(int c) {
  if (items.size() == 0)
    cout << c << endl;
  else if (items.size() == 1) {
    cout << "(" << c << "+((abs((t-" << items[0].second << "))+(t-"
         << items[0].second << "))*";
    printNum(items[0].first);
    cout << "))" << endl;
  } else {
    if (c != 0) cout << "(" << c << "+";
    printFunc(c, 0);
    if (c != 0)
      cout << ")" << endl;
    else
      cout << endl;
  }
}
int n;
int x[100], y[100];
int main() {
  cin >> n;
  int temp;
  for (int i = 0; i < n; i++) cin >> x[i] >> y[i] >> temp;
  createFunc(x + 1, n - 1, 0, 0, x[0]);
  printFunc(x[0]);
  items.clear();
  createFunc(y + 1, n - 1, 0, 0, y[0]);
  printFunc(y[0]);
  return 0;
}
