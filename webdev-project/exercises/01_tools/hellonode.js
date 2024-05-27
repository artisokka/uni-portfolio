const _ = require("lodash");
    const ver = _.VERSION;
    // console.log(ver);

    let array = ["hello", "goodbye", "alpha", "omega", "edge", "node"];

    function hithere(array) {
        
        let str1 = _.last(array);
        let str2 = _.head(array);

        const newstr = str1.concat(str2);

        return newstr;
    };

    console.log(hithere(array));

    module.exports = hithere;