#include <bits/stdc++.h>
using namespace std;
int n;
void lia(string s,char c){
    if(s.size()==n) cout << s << endl;
    else{
       for(char i='a';i<=c;i++){
           if(c==i) lia(s+i,c+1);
           else lia(s+i,c);
       }
    }
}
int main(){
    cin >> n;
    lia("",'a');
}