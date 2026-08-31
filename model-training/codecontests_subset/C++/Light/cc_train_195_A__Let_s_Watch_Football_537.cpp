#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b >> c;
  int needed_data = a * c;
  int formed_data_during_video = b * c;
  needed_data -= formed_data_during_video;
  int max_weight = float(needed_data) / float(b) > float(needed_data / b)
                       ? needed_data / b + 1
                       : needed_data / b;
  cout << max_weight;
  return 0;
}
