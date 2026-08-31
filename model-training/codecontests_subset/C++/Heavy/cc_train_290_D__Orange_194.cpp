#include <bits/stdc++.h>
using namespace std;
char l(char i) {
  if (i >= 'a') return i;
  return i + ('a' - 'A');
}
char u(char i) {
  if (i >= 'a') return i - ('a' - 'A');
  return i;
}
string lower(string in) {
  string a;
  for (int i = (0); i < (in.size()); ++i) {
    a += l(in[i]);
  }
  return a;
}
string upper(string in) {
  string a;
  for (int i = (0); i < (in.size()); ++i) {
    a += u(in[i]);
  }
  return a;
}
int main() {
  string v27;
  int v16;
  cin >> v27;
  cin >> v16;
  string v4;
  v27 = lower(v27);
  for (int v26 = (0); v26 < (v27.length()); ++v26) {
    char v19 = v27[v26];
    if (v19 < 97 + v16)
      v4 += u(v19);
    else
      v4 += l(v19);
  }
  cout << v4 << "\n";
}
