
#include <iostream>
#include <math.h>
#include <string>
#include <algorithm>
#include <set>
using namespace std;

int n;
bool c[5][20];
char suit[4]={'S','H','C','D'};

int main(){
    cin>>n;
    for(int i=0;i<n;i++){
        char s;cin>>s;
        int num;cin>>num;
        for(int j=0;j<4;j++){
            for(int k=1;k<=13;k++){
                if(s==suit[j]&&k==num)c[j][k]=true;
            }
        }
    }
    for(int i=0;i<4;i++){
        for(int j=1;j<=13;j++){
            if(!c[i][j])cout<<suit[i]<<" "<<j<<endl;
        }
    }
    return 0;
}
