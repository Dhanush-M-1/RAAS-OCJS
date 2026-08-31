#include <bits/stdc++.h>
using namespace std;
int compare(const void* a, const void* b) { return (*(int*)a - *(int*)b); }
int main() {
  string buffer;
  cin >> buffer;
  int c;
  cin >> c;
  c += 97;
  for (int i = 0; i < buffer.size(); i++) {
    buffer[i] = tolower(buffer[i]);
    if (buffer[i] < c) buffer[i] = toupper(buffer[i]);
  }
  cout << buffer;
  return 0;
}
