#include <bits/stdc++.h>
using namespace std;
string str(int n, int b) {
  string ret;
  for (; n; n /= b) ret.push_back(n % b + '0');
  reverse((ret).begin(), (ret).end());
  return ret;
}
void run() {
  int k;
  cin >> k;
  for (int i = 0; i < k - 1; i++) {
    string s;
    for (int j = 0; j < k - 1; j++) s += str((i + 1) * (j + 1), k) + " ";
    cout << s << endl;
  }
}
int main() {
  run();
  return 0;
}
