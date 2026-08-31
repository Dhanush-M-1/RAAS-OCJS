#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, freq[27], resp = 1, repet, cont_aux = 0;
  string s;
  char* aux = new char[1001];
  cin >> k;
  cin >> s;
  for (int i = 0; i < 27; i++) {
    freq[i] = 0;
  }
  for (int i = 0; i < s.length(); i++) {
    freq[s[i] - 96]++;
  }
  for (int i = 1; i < 27; i++) {
    if (freq[i] % k != 0) {
      resp = 0;
      break;
    }
  }
  if (resp == 0)
    cout << "-1";
  else {
    for (int i = 1; i < 27; i++) {
      repet = freq[i] / k;
      for (int j = cont_aux; j < cont_aux + repet; j++) {
        aux[j] = i + 96;
      }
      cont_aux = cont_aux + repet;
    }
  }
  for (int i = 0; i < k; i++) {
    for (int j = 0; j < cont_aux; j++) {
      cout << aux[j];
    }
  }
  return 0;
}
