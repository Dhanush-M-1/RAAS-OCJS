#include<iostream>
#include<string>
using namespace std;

int main(){
  int n;
  int d_words[5]={5,7,5,7,7};
  while(cin>>n && n!=0){
    int* n_words=new int[n];
    for(int i=0;i<n;i++){
      string str;
      cin>>str;
      n_words[i]=str.size();
    }
    int start=0;
    int success=0;
    while(!success){
      int t_words=0;
      int tmp=start;
      int tmp2=0;
      while(1){
        tmp2+=n_words[tmp];
        if(tmp2==d_words[t_words]){
          t_words++;
tmp2=0;
          if(t_words==5){
            success=start+1;
            break;
          }
}else if(tmp2>d_words[t_words]){
            break;
          }
       
        tmp++;
      }
      start++;
    }
    cout<<success<<endl;
  }
}

