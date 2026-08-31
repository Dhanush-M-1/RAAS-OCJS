#include<iostream>
using namespace std;
#define lp(i,n) for(int i=1;i<=n;i++)
int main(){
    int n;
    while(1){
        cin>>n;
        if(n == 0) break;
        int a=0, count=0;
        string s;
        lp(i,n){
            cin>>s;
            if(s=="lu") a++;
            if(s=="ld") a--;
            if(s=="ru") a++;
            if(s=="rd") a--;
            if(a ==  2 || a == -2) count++;
            if(i % 2 == 0) a=0;
        }
        cout<<count<<endl;
    }
    return 0;
}

