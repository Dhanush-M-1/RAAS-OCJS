#include<iostream>
#include<string>
using namespace std;
void func(int N,int next,string s) {
  if(N == 0) {
    cout << s << endl;
    return;
  }
  int i;
  for(i=0;i<=next;i++)func(N-1,max(next,i+1),s+(char)('a'+i));
}
int main() {
  int N;
  cin >> N;
  func(N,0,"");
}