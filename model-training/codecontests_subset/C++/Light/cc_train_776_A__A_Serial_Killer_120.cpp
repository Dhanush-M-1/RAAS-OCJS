#include <bits/stdc++.h>
using namespace std;
int main() {
  int N;
  string str[2];
  cin >> str[0] >> str[1];
  scanf("%d", &N);
  cout << str[0] << " " << str[1] << endl;
  for (int i = 0; i < N; ++i) {
    string a, b;
    cin >> a >> b;
    if (str[0] == a)
      str[0] = b;
    else
      str[1] = b;
    cout << str[0] << " " << str[1] << endl;
  }
  return 0;
}
