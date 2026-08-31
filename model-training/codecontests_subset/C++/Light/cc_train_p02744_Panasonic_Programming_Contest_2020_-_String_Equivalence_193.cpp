#include <iostream>
#include <string>
using namespace std;
int N;
void dfs(string s, char mxc) {
  if(s.size() == N) {
    cout << s << endl;
  } else {
    for(char c = 'a'; c <= mxc; ++c) {
      dfs(s+c, (c==mxc?mxc+1:mxc));
    }
  }
}
int main() {
  cin >> N;
  dfs("", 'a');
}