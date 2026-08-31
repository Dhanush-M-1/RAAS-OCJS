#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  cin >> n;
  priority_queue<int,vector<int>,greater<int> > a;
  for(int i=0;i<n;i++){
    int x,y;
    cin >> x >> y;
    a.push(x+y);
  }
  //sort(a.begin(),a.end());
  int p1;
  while(!a.empty()){
    p1=a.top();a.pop();
    if(a.empty()){
      cout << p1 << " 0" << endl;
      break;
    }
    else if(p1==a.top()){
      a.pop();
      a.push(p1+1);
    }
    else{
      cout << p1 << " 0" << endl;
    }
  }
  return 0;
}