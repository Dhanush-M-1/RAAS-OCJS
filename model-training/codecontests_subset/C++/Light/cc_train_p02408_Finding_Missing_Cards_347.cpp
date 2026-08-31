#include<iostream>
#include<cstdio>
#include<cstring>
#include<map>
using namespace std;
int cards[4][14]={{0},{0},{0},{0}};
char type[4]={'S','H','C','D'};

void pp(int n){
    for(int i=1;i<14;i++)
        if(!cards[n][i]) 
            cout<<type[n]<<" "<<i<<endl;
}

int main()
{   
    map<char,int> t;
    for(int i=0;i<4;i++)
        t[type[i]] = i;
    
    char c; int n,m;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>c>>m;
        cards[t[c]][m] = 1;
    }
    
    for(int i=0;i<4;i++)
        pp(i);

}
