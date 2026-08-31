var n = +readline();

const FALL = {
    yes: {},
    maybe: {},
    no: {}
};

var fallType = function (fallTree, blockTree) {
    var distance = Math.abs(fallTree.x - blockTree.x);

    if (fallTree.h + blockTree.h < distance) {
        return FALL.yes;
    }

    if (fallTree.h < distance) {
        return blockTree.h >= distance ? FALL.yes : FALL.maybe;
    }

    return FALL.no;
};

var Tree = function (data) {
    this.x = +data[0];
    this.h = +data[1];
};

Tree.prototype.calculate = function (leftTree, rightTree) {
    this.left = fallType(this, leftTree);
    this.right = fallType(this, rightTree);
};

Tree.prototype.canFall = function () {
    return this.left === FALL.yes || this.right === FALL.yes;
};

Tree.prototype.cantFall = function () {
    return this.left === FALL.no && this.right === FALL.no;
};

var trees = [new Tree([-Infinity, 0])];
for (var i = 0; i < n; ++i) {
    trees.push(new Tree(readline().split(' ')));
}
trees.push(new Tree([+Infinity, 0]));

for (var i = 1; i <= n; ++i) {
    trees[i].calculate(trees[i - 1], trees[i + 1]);
}

var result = 0;
var state = 0;

for (var i = 1; i <= n; ++i) {
    switch (state) {
        case 0:
            if (trees[i].canFall()) {
                ++result;
                state = 0;
            } else {
                if (trees[i].cantFall()) {
                    state = 0;
                } else {
                    if (trees[i].left === FALL.no) {
                        ++result;
                        state = 1;
                    } else {
                        ++result;
                    }
                }
            }
            break;
        case 1:
            if (trees[i].canFall()) {
                ++result;
                state = 0;
            } else {
                if (trees[i].cantFall()) {
                    state = 0;
                } else {
                    if (trees[i].right === FALL.no) {
                        state = 0;
                    } else {
                        ++result;
                    }
                }
            }
            break;
    }
}

write(result);