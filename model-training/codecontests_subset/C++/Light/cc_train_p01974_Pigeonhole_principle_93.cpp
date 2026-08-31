#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  int N;
  vector<int> vec_a;
  
  cin >> N;
  for (int i = 0; i < N; i++) {
    int a;
    cin >> a;
    vec_a.push_back(a);
  }

  sort(vec_a.begin(), vec_a.end());

  bool isPigeon = false;
  for (int i = 0; i < N - 1; i++) {
    for (int j = i + 1; j < N; j++) {
      int diff = vec_a.at(j) - vec_a.at(i);
      if (!((vec_a.at(j) - vec_a.at(i)) % (N - 1))) {
        cout << vec_a.at(i) << " " << vec_a.at(j) << endl;
        isPigeon = true;
        break;
      }
    }
    if (isPigeon) {
      break;
    }
  }
}
 

