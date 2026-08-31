#include<iostream>
using namespace std;

static char MARK[4]={'S','H','C','D'};
int n,num;
char mark;
bool existCard[4][14]={false};

int main(){
    cin>>n;
    for(int i=0;i<n;++i){
        cin>>mark>>num;
        for(int j=0;j<4;++j){
            if(mark==MARK[j]){
                existCard[j][num]=true;
            }
        }
    }
    for(int i=0;i<4;++i){
        for(int j=1;j<=13;++j){
            if(existCard[i][j]==false)
                cout<<MARK[i]<<" "<<j<<endl;
        }
    }
    return 0;
}
