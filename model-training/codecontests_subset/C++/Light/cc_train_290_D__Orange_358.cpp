#include <bits/stdc++.h>
using namespace std;
ifstream fin("input.txt");
ofstream fout("output.txt");
int k;
string str;
int main() {
  cin >> str >> k;
  for (int i = 0; i < str.length(); i++) {
    if (islower(str[i]) && str[i] < 'a' + k) str[i] += 'A' - 'a';
    if (isupper(str[i]) && str[i] >= 'A' + k) str[i] -= 'A' - 'a';
  }
  cout << str << endl;
}
