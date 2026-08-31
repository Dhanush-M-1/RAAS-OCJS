#include <bits/stdc++.h>
using namespace std;
int main() {
  int str_len, I_count = 0, A_count = 0;
  string inp;
  cin >> str_len;
  cin >> inp;
  for (int i = 0; i < inp.size(); i++) {
    if (inp[i] == 'I') I_count++;
    if (inp[i] == 'A') A_count++;
  }
  if (I_count > 1)
    cout << "0"
         << "\n";
  else if (I_count == 1)
    cout << "1"
         << "\n";
  else
    cout << A_count << "\n";
  return 0;
}
