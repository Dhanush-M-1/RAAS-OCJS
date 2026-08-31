#include<iostream>
#include<string>
int a[40],n;
int haiku(int);
using namespace std;
int main(){
  while(1){
    string x;
    cin >> n;
    if(n==0)break;
    for(int i=0;i<n;i++){
      cin >> x;
      a[i]=x.size();
    }
    int f;
    for(int i=0;i<n;i++){
      f=haiku(i);
      if(f==1){
	cout << i+1 << endl;
	break;
      }
    }
  }
  return 0;
}
int haiku(int x){
  int c=0,c2=0;
  for(int i=x;i<n;i++){
    c+=a[i];
    if(c2==0||c2==2){
      if(c<5)continue;
      else if(c==5){
	c=0;
	c2++;
	continue;
      }
      else return 0;
    }
    else{
      if(c<7)continue;
      if(c==7){
	c=0;
	c2++;
	if(c2==5)return 1;
	continue;
      }
      else return 0;
    }
  }
  return 0;
}
      