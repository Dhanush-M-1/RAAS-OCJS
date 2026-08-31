#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch[101];
  cin >> ch;
  for (int i = 0; i < strlen(ch); i += 2) {
    int currMin = ch[i] - '0';
    int minIndex = i;
    for (int j = i + 2; j < strlen(ch); j += 2) {
      if (currMin > ch[j] - '0') {
        currMin = ch[j] - '0';
        minIndex = j;
      }
    }
    swap(ch[i], ch[minIndex]);
  }
  cout << ch << endl;
}
